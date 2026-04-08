package com.mayoristas.interfaz_contable.auth.custom_user_details.domain;

import java.util.Optional;

public interface CustomUserDetailRepository {

    Optional<CustomUserDetail> findByUsername(String username);

}
