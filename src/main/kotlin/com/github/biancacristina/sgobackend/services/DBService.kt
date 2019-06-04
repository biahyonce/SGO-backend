package com.github.biancacristina.sgobackend.services

import com.github.biancacristina.sgobackend.domain.*
import com.github.biancacristina.sgobackend.repositories.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DBService {

    @Autowired
    private lateinit var cityRepository: CityRepository

    @Autowired
    private lateinit var stateRepository: StateRepository

    @Autowired
    private lateinit var clusterRepository: ClusterRepository

    @Autowired
    private lateinit var typeOfLaborRepository: TypeOfLaborRepository

    @Autowired
    private lateinit var laborRepository: LaborRepository

    @Autowired
    private lateinit var typeOfCostAggregationRepository: TypeOfCostAggregationRepository

    fun instantiateTestDataBase(): Unit {
        var e1 = State(0, "Minas Gerais")
        var e2 = State(0, "Rio de Janeiro")
        var e3 = State(0, "São Paulo")

        stateRepository.saveAll(Arrays.asList(e1,e2,e3))

        var c1 = City(0, "Uberlândia", e1)
        var c2 = City(0, "Belo Horizonte", e1)
        var c3 = City(0, "São Paulo", e3)

        cityRepository.saveAll(Arrays.asList(c1,c2,c3))
        stateRepository.saveAll(Arrays.asList(e1,e2,e3))

        var clu1 = Cluster(0, "Vila Maria", c1)
        var clu2 = Cluster(0, "Nova Uberlândia", c1)
        var clu3 = Cluster(0, "Higienopólis", c3)

        clusterRepository.saveAll(Arrays.asList(clu1, clu2, clu3))
        cityRepository.saveAll(Arrays.asList(c1,c2,c3))

        var tl1 = TypeOfLabor(0, "Pequena")
        var tl2 = TypeOfLabor(0, "Média")
        var tl3 = TypeOfLabor(0, "Grande")

        typeOfLaborRepository.saveAll(Arrays.asList(tl1,tl2,tl3))

        var l1 = Labor(0,
                123.12,
                678.78,
                988.90,
                43.10,
                54.11,
                clu1,
                tl1)

        var l2 = Labor(0,
                454.21,
                1000.43,
                987.12,
                534.90,
                745645.45,
                clu2,
                tl2)

        laborRepository.saveAll(Arrays.asList(l1,l2))
        clusterRepository.saveAll(Arrays.asList(clu1, clu2, clu3))
        typeOfLaborRepository.saveAll(Arrays.asList(tl1,tl2,tl3))

        var tca1 = TypeOfCostAggregation(0, "Ag 1")
        var tca2 = TypeOfCostAggregation(0, "Ag 2")

        typeOfCostAggregationRepository.saveAll(Arrays.asList(tca1, tca2))
    }
}