package com.example.universidadtrackerapplication.data

import com.example.universidadtrackerapplication.data.model.UniversityModel

//  Declaracion de atributos de universidad0
val name0 = "UCA"
val location0 = "Antiguo Cuscatlan"

//  universidad0
val university0 = UniversityModel(name0, location0)

//  Declaracion de atributos de universidad1
val name1 = "UNIVO"
val location1 = "San Miguel"

//  universidad1
val university1 = UniversityModel(name1, location1)

//  Declaracion de atributos de universidad2
val name2 = "UES"
val location2= "San Salvador"

//  universidad2
val university2 = UniversityModel(name2, location2)

//  Lista de universidades
var universitiesListDummyData = mutableListOf<UniversityModel>(university0, university1, university2)