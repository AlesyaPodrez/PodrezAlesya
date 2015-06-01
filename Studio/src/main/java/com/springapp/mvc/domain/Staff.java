package com.springapp.mvc.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "staff")
@XmlRootElement
public class Staff {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_staff")
    private Integer idStaff;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Basic(optional = false)
    @Column(name = "experience")
    private String experience;
    @JoinColumn(name = "id_post", referencedColumnName = "id_post")
    @ManyToOne(optional = false)
    private Post idPost;
    @JoinColumn(name = "id_project", referencedColumnName = "id_project")
    @ManyToOne(optional = false)
    private Project idProject;

    public Staff() {
    }

    public Staff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public Staff(Integer idStaff, String surname, String name, String lastname, String dateOfBirth, String experience) {
        this.idStaff = idStaff;
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
        this.idProject = idProject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStaff != null ? idStaff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.idStaff == null && other.idStaff != null) || (this.idStaff != null && !this.idStaff.equals(other.idStaff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Staff[ idStaff=" + idStaff + " ]";
    }

}

