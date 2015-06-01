package com.springapp.mvc.controller;

import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AllController {

    private ActorRepository actorRepository;
    private PostRepository postRepository;
    private ProjectRepository projectRepository;
    private RoleRepository roleRepository;
    private StaffRepository staffRepository;
    private TypeRepository typeRepository;

    @Autowired
    public AllController(ActorRepository actorRepository, PostRepository postRepository, ProjectRepository projectRepository, RoleRepository roleRepository,
                         StaffRepository staffRepository, TypeRepository typeRepository){
        this.actorRepository = actorRepository;
        this.postRepository = postRepository;
        this.projectRepository = projectRepository;
        this.roleRepository = roleRepository;
        this.staffRepository = staffRepository;
        this.typeRepository = typeRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Actor> actor = this.actorRepository.listAll();
        model.addAttribute("actor", actor);

        List<Post> post = this.postRepository.listAll();
        model.addAttribute("post", post);

        List<Project> project = this.projectRepository.listAll();
        model.addAttribute("project", project);

        List<Role> role = this.roleRepository.listAll();
        model.addAttribute("role", role);

        List<Staff> staff = this.staffRepository.listAll();
        model.addAttribute("staff", staff);

        List<myType> myType = this.typeRepository.listAll();
        model.addAttribute("type", myType);

        return "index";
    }

    @RequestMapping(value = "addType", method = RequestMethod.GET)
    public String addType(Model model) {
        model.addAttribute("type", new myType());
        return "addType";
    }

    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public String addType(@ModelAttribute("type") myType type) {
        this.typeRepository.addType(type);
        return "redirect:/";
    }

    @RequestMapping(value = "deleteType/{id}", method = RequestMethod.GET)
    public String deleteType(@PathVariable Integer id) {
        this.typeRepository.removeType(id);
        return "redirect:/";
    }

    @RequestMapping(value = "editType/{id}", method = RequestMethod.GET)
    public String editType(@PathVariable(value="id") Integer id, Model model) {
        model.addAttribute("type", this.typeRepository.findType(id));
        return "editType";
    }

    @RequestMapping(value = "/editType", method = RequestMethod.POST)
    public String editType(@ModelAttribute("type") myType type) {
        this.typeRepository.updateType(type);
        return "redirect:/";
    }

    @RequestMapping(value = "allProject", method = RequestMethod.GET)
    public String allProject(Model model) {
        List<Project> project = this.projectRepository.listAll();
        model.addAttribute("project", project);
        return "allProject";
    }

    @RequestMapping(value = "allActor", method = RequestMethod.GET)
    public String allActor(Model model) {
        List<Actor> actor = this.actorRepository.listAll();
        model.addAttribute("actor", actor);
        return "allActor";
    }

    @RequestMapping(value = "allStaff", method = RequestMethod.GET)
    public String allStaff(Model model) {
        List<Staff> staff = this.staffRepository.listAll();
        model.addAttribute("staff", staff);
        return "allStaff";
    }
}
