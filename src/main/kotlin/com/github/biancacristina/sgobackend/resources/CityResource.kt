package com.github.biancacristina.sgobackend.resources

import com.github.biancacristina.sgobackend.services.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value=["/cities"])
class CityResource {

    @Autowired
    private lateinit var cityService: CityService

    @RequestMapping(value=["/{id}"], method=[RequestMethod.GET])
    fun findById(@PathVariable id: Long): ResponseEntity<*> {
        var obj = cityService.findById(id)

        return ResponseEntity.ok().body(obj)
    }
}