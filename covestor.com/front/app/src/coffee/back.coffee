$.getJSON "http://localhost:8080/covestorCodeTestBack/getEachPostingMostCommonWords", (json) ->
  drawTable('back', json)

$.getJSON "http://localhost:8080/covestorCodeTestBack/getAllPostingsMostCommonWords", (text) ->
  $("#globalMostCommonWords").text(text)