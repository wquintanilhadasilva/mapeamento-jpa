package br.mil.eb.cds.sisgcorp.registro.dominio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "core")
@Builder
public class User implements UserDetails{

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String emailUsuario;

    @Column(name = "pass")
    private String pass;

    @Column(name = "name")
    private String nameUsuario;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinTable(
        name = "user_perfis",
        schema = "core",
        joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_perfil")
    )
    private Set<Perfil> perfis = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        final Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        this.getPerfis().stream().forEach(perfil -> {
            var perfilRolesSet = perfil.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toSet());
            authorities.addAll(perfilRolesSet);
        });

        return authorities;

    }

    public Set<String> getRoles() {

        final Set<String> roles = new HashSet<>();

        this.getPerfis().stream().forEach(perfil -> {
            var perfilRolesSet = perfil.getRoles().stream().map(AppRoles::name).collect(Collectors.toSet());
            roles.addAll(perfilRolesSet);
        });

        return roles;

    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    @Override
    public String getUsername() {
        return this.nameUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}