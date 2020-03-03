package com.projet.liste;

import java.text.SimpleDateFormat;
import java.util.Date;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("prenom")
public class ListeController {

	@Autowired
	ListeAFaireService listeAFaireService;

	/**
	 * Permet de donner la possibilité à l'utilisateur de définir la date
	 * 
	 * @param bider
	 */
	@InitBinder
	public void formatDate(WebDataBinder bider) {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		bider.registerCustomEditor(Date.class, new CustomDateEditor(simpleDate, false));
	}

	private String prenom() {
		return "Mes élèves";
	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public String ListeDesTaches(Model model) {

		model.addAttribute("liste", listeAFaireService.recupererListe(prenom()));

		return "liste";
	}

	@RequestMapping(value = "/ajout-liste", method = RequestMethod.GET)
	public String AfficherFormulaire(int id, Model model) {

//		throw new RuntimeException("error");

		model.addAttribute("liste", new ListeAFaire(0, "Mes élèves", "TEST1", new Date(), false));

		model.addAttribute("liste", new ListeAFaire());

		return "ajout-liste";
	}

	@RequestMapping(value = "/bienvenue", method = RequestMethod.GET)
	public String AfficherPageAccueil(Model model) {

		return "bienvenue";
	}

	@RequestMapping(value = "/ajout-liste", method = RequestMethod.POST)
	public String AjoutTaches(@RequestParam String description, @Valid @ModelAttribute("liste") ListeAFaire listeAFaire,
			BindingResult result) {

		if (result.hasErrors()) {

			return "ajout-liste";
		}

		listeAFaireService.ajouterListe("Mes élèves", description, new Date(), false);

		return "redirect:liste";
	}

	@RequestMapping(value = "/supprimer-tache", method = RequestMethod.GET)
	public String Supprimer(@RequestParam int id) {

		listeAFaireService.supprimerListe(id);

		return "redirect:liste";
	}

	@RequestMapping(value = "/modifier-tache", method = RequestMethod.GET)
	public String afficherTache(@RequestParam int id, Model model) {

		ListeAFaire tache = listeAFaireService.recupererTache(id);

		model.addAttribute("liste", tache);

		return "modifier-liste";
	}

	@RequestMapping(value = "/modifier-liste", method = RequestMethod.POST)
	public String ModifierTache(@Valid @ModelAttribute("liste") ListeAFaire listeAFaire, BindingResult result) {

		if (result.hasErrors()) {

			return "modifier-liste";
		}

		listeAFaire.setTargetDate(new Date());
		listeAFaire.setUtilisateur("Mes élèves");
		listeAFaireService.mettreAJourTache(listeAFaire);

		return "redirect:liste";
	}
}
