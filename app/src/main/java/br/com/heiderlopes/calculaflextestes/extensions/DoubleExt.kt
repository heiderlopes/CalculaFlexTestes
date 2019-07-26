package br.com.heiderlopes.calculaflextestes.extensions

fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)