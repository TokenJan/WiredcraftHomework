package com.wiredcraft.homework.adapter.persistence.po;

import com.wiredcraft.homework.domain.model.User;
import com.wiredcraft.homework.domain.valueobject.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Optional;

@Data
@Entity
@SuperBuilder
@Table(name = "t_user")
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UserPo extends AbstractPersistenceObject {

    private String name;

    private LocalDate dateOfBirth;

    private String address;

    private String description;

    public static UserPo fromDomain(User user) {
        Long id = Optional.ofNullable(user.getId())
                .map(UserId::getId)
                .orElse(null);
        return UserPo.builder()
                .id(id)
                .name(user.getName())
                .dateOfBirth(user.getDob())
                .address(user.getAddress())
                .description(user.getDescription())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public User toDomain() {
        return new User(id, name, dateOfBirth, address, description, createdAt);
    }

}


