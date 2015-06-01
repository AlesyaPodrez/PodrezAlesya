package com.springapp.mvc.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@Table(name = "project")
@XmlRootElement
public class Project {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_project")
    private Integer idProject;
    @Basic(optional = false)
    @Column(name = "year")
    private String year;
    @Basic(optional = false)
    @Column(name = "name_project")
    private String nameProject;
    @Basic(optional = false)
    @Column(name = "coutry")
    private String coutry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProject")
    private Collection<Role> roleCollection;
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    @ManyToOne(optional = false)
    private myType idType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProject")
    private Collection<Staff> staffCollection;

    public Project() {
    }

    public Project(Integer idProject) {
        this.idProject = idProject;
    }

    public Project(Integer idProject, String year, String nameProject, String coutry) {
        this.idProject = idProject;
        this.year = year;
        this.nameProject = nameProject;
        this.coutry = coutry;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    public myType getIdType() {
        return idType;
    }

    public void setIdType(myType idMyType) {
        this.idType = idMyType;
    }

    @XmlTransient
    public Collection<Staff> getStaffCollection() {
        return staffCollection;
    }

    public void setStaffCollection(Collection<Staff> staffCollection) {
        this.staffCollection = staffCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProject != null ? idProject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idProject == null && other.idProject != null) || (this.idProject != null && !this.idProject.equals(other.idProject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Project[ idProject=" + idProject + " ]";
    }

}

