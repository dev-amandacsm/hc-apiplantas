package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "planta")
@Table(name = "tb_planta", schema = "db_herbcare_teste")
@NoArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_planta")
    private Long id;

    @Column(name = "nm_popular", nullable = false, unique = true, length = 60)
    private String popularName;

    @Column(name = "nm_cientifico", nullable = false, unique = true, length = 60)
    private String scientificName;

    @Column(name = "ds_receita", nullable = false, length = 256)
    private String recipe;

    @ManyToOne
    @JoinColumn(name="cd_categoria", nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(name = "tb_planta_sintoma",
            joinColumns = @JoinColumn(name = "cd_planta"),
            inverseJoinColumns = @JoinColumn(name = "cd_sintoma"))
    private Set<Symptom> symptoms = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_planta_restricao",
            joinColumns = @JoinColumn(name = "cd_planta"),
            inverseJoinColumns = @JoinColumn(name = "cd_restricao"))
    private Set<Restriction> restrictions = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public String getPopularName() {
        return this.popularName;
    }

    public String getScientificName() {
        return this.scientificName;
    }

    public String getRecipe() {
        return recipe;
    }

    public Category getCategory() {
        return this.category;
    }

    public Set<Symptom> getSymptoms() {
        return symptoms;
    }

    public Set<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setPopularName(String popularName) {
        this.popularName = popularName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void addSymptom(Symptom symptom) {
        symptoms.add(symptom);
    }

    public void removeSymptom(Symptom symptom){
        symptoms.remove(symptom);
    }

    public void addRestriction(Restriction restriction) {
        restrictions.add(restriction);
    }

    public void removeRestriction(Restriction restriction){
        restrictions.remove(restriction);
    }
}
