package com.masprogtechs.helpdesk.security.jwt;

import com.masprogtechs.helpdesk.entities.User;
import com.masprogtechs.helpdesk.enums.ProfileEnum;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;


public class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(User user) { // converte e gera um JWTuser com base nos dados do usuário
        return new JwtUser(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getProfile())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) { // convert o perfil do usuario para formato do spring security
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
        return   authorities ;
    }

}
