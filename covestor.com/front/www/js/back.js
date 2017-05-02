(function() {
  $.getJSON("http://localhost:8080/covestorCodeTestBack/getEachPostingMostCommonWords", function(json) {
    return drawTable('back', json);
  });

  $.getJSON("http://localhost:8080/covestorCodeTestBack/getAllPostingsMostCommonWords", function(text) {
    return $("#globalMostCommonWords").text(text);
  });

}).call(this);
