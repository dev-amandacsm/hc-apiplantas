package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "usuario")
@Table(name = "tb_usuario", schema = "db_herbcare_teste")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nm_usuario", unique = true, length = 150, nullable = false)
    private String name;

    @Column(name = "ds_login", unique = true, length = 45, nullable = false)
    private String login;

    @Column(name = "ds_senha", length = 45, nullable = false)
    private String password;

    @Column(name = "ds_profile", length = 10, nullable = false)
    private String profile;

    @Column(name = "ds_logradouro", length = 45, nullable = false)
    private String street;

    @Column(name = "ds_complemento", length = 45)
    private String addressComplement;

    @ManyToOne
    @JoinColumn(name = "cd_bairro", nullable = false)
    private District district;

    @ManyToMany
    @JoinTable(name = "tb_favorito",
            joinColumns = @JoinColumn(name = "cd_usuario"),
            inverseJoinColumns = @JoinColumn(name = "cd_planta"))
    private Set<Plant> plants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile){
        this.profile = profile;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Set<Plant> getPlants() {
        return plants;
    }

    public void setPlants(Set<Plant> plants) {
        this.plants = plants;
    }

}
