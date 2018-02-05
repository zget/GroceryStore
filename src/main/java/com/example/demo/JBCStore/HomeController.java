package com.example.demo.JBCStore;


import com.example.demo.Repositories.CleanRepository;
import com.example.demo.Repositories.CosmoRepository;
import com.example.demo.Repositories.SnackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    CosmoRepository cosmoRepository;
    @Autowired
    CleanRepository cleanRepository;
    @Autowired
    SnackRepository snackRepository;
  private double total_revenue=0;

    @RequestMapping("/")

    public String JBCstore(Model model) {return "redirect:/addcosmotics";}


    @GetMapping("/addcosmotics")
    public String loadCosmoForm(Model model){

        model.addAttribute("cosmotics", new Cosmetics());
        return "cosmoform";
    }

    @PostMapping("/processcosmo")

    public String processCosmoForm(@Valid @ModelAttribute("cosmetics") Cosmetics cosmetics, BindingResult result){
        if(result.hasErrors())
            return "cosmoform";
        cosmoRepository.save(cosmetics);
        total_revenue+=cosmetics.getTotal();
        return "redirect:/addcosmotics";
    }

    @GetMapping("/addcleaningitems")
    public String loadCleanForm(Model model){

        model.addAttribute("cleaningitem", new CleaningItems());
        return "cleanform";
    }

    @PostMapping("/processclean")

    public String processCleanForm(@Valid @ModelAttribute CleaningItems cleaningitem, BindingResult result){
        if(result.hasErrors())
            return "cleanform";
        cleanRepository.save(cleaningitem);
        total_revenue+=cleaningitem.getTotal();
        return "redirect:/addcleaningitems";
    }


    @GetMapping("/addsnack")
    public String loadSnackForm(Model model){
        model.addAttribute("snack",new Snacks());
        return "snackform";

    }

    @PostMapping("/processsnack")

        public String processSnackForm(@Valid @ModelAttribute Snacks snack, BindingResult result){

        if(result.hasErrors())
            return "snackform";
        snackRepository.save(snack);
        total_revenue+=snack.getTotal();
        return "redirect:/addsnack";

    }
    @GetMapping("/displayJBCinventory")
    public String displayInventory(Model model){
        model.addAttribute("cosmoticses", cosmoRepository.findAll());
        model.addAttribute("cleaningitems", cleanRepository.findAll());
        model.addAttribute("snacks", snackRepository.findAll());
        model.addAttribute("totalRevenue", total_revenue);
        return "inentorylist";
    }


}
