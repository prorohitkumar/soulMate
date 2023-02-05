package com.stackroute.SoulmateService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author Rohit
 * @Date 29-Oct-21 4:29 PM
 */
@Document @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Profile {
        @Id
        private String email;
        private String Name;
        private int age;
        private String gender;
        private String city;
}
