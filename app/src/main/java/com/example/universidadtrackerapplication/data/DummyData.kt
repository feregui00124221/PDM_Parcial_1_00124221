package com.example.universidadtrackerapplication.data

import com.example.universidadtrackerapplication.data.model.UniversidadModel

//  Declaracion de atributos de universidad0
val nombre0 = "UCA"
val ubicacion0 = "Antiguo Cuscatlan"

//  universidad0
val universidad0 = UniversidadModel(nombre0, ubicacion0)

//  Declaracion de atributos de universidad1
val nombre1 = "UNIVO"
val ubicacion1 = "San Miguel"

//  universidad1
val universidad1 = UniversidadModel(nombre1, ubicacion1)

//  Lista de universidades
var universidadesListDummyData = mutableListOf<UniversidadModel>(universidad0, universidad1)