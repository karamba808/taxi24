package bk.project.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean status;
    private String names;
    private String riderKey;
    private double lat;
    private double lng;
}
