package com.mayoristas.interfaz_contable.auth.custom_user_details.application.find_by_username;

import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.CustomUserDetail;
import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.CustomUserDetailRepository;
import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.CustomUserDetailsNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsFinderByUsername {
    private final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsFinderByUsername.class);
    private CustomUserDetailRepository repository;

    public CustomUserDetailsFinderByUsername(CustomUserDetailRepository repository) {
        this.repository = repository;
    }

    public CustomUserDetail findByUsername(FindByUsernameCustomUserDetailsQuery query)
    throws CustomUserDetailsNotFound {
        var optionalUserDetails = repository.findByUsername(query.getUsername());
        if (optionalUserDetails.isEmpty()) {
            throw new CustomUserDetailsNotFound(query.getUsername());
        }
        LOG.info("Custom User Details:"+optionalUserDetails.get().toString());
        return optionalUserDetails.get();
    }

}
