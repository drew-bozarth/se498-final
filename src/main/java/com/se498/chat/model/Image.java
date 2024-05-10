package com.se498.chat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Image {

    @Id
    private String imageId;
    @NonNull
    @Column
    private String url;
    @NonNull
    @Column(length=1024)
    private String description;
}
