package com.github.biancacristina.sgobackend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Cluster (
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    var id: Long,

    var name: String,

    @ManyToOne
    @JoinColumn(name="city_id")
    var city: City
) {
    @JsonIgnore
    @OneToMany(mappedBy= "cluster")
    var labors = mutableSetOf<Labor>()
}