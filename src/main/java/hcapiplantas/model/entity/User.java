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

}
