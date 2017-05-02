isAnimalColumnOrderAsc = null
isLegsColumnOrderAsc = null
data = null

$.getJSON "http://api.covestor.com/ajax-test?callback=?", (json) ->
  drawTable('front', json)
  data = json

$("#animalColumn").click (event) ->
  alphabeticAscOrder(data)
  isAnimalColumnOrderAsc = reverseForDescOrder(isAnimalColumnOrderAsc, data)
  drawTable('front', data)

$("#legsColumn").click (event) ->
  numericAscOrder(data)
  isLegsColumnOrderAsc = reverseForDescOrder(isLegsColumnOrderAsc, data)
  drawTable('front', data)
