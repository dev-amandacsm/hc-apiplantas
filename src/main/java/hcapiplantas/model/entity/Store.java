package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "loja")
@Table(name = "tb_loja", schema = "db_herbcare_teste")
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_loja")
    private Long id;

    @Column(name = "nm_Loja", unique = true, length = 45, nullable = false)
    private String name;

    @Column(name = "ds_loja", length = 200, nullable = false)
    private String description;

    @Column(name = "ds_contato", length = 45, nullable = false)
    private String contact;

    @Column(name = "ds_logradouro", length = 45, nullable = false)
    private String street;

    @Column(name = "ds_complemento", length = 45)
    private String addressComplement;

    @ManyToOne
    @JoinColumn(name = "cd_bairro", nullable = false)
    private District district;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

}
