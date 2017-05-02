(function() {
  var data, isAnimalColumnOrderAsc, isLegsColumnOrderAsc;

  isAnimalColumnOrderAsc = null;

  isLegsColumnOrderAsc = null;

  data = null;

  $.getJSON("http://api.covestor.com/ajax-test?callback=?", function(json) {
    drawTable('front', json);
    return data = json;
  });

  $("#animalColumn").click(function(event) {
    alphabeticAscOrder(data);
    isAnimalColumnOrderAsc = reverseForDescOrder(isAnimalColumnOrderAsc, data);
    return drawTable('front', data);
  });

  $("#legsColumn").click(function(event) {
    numericAscOrder(data);
    isLegsColumnOrderAsc = reverseForDescOrder(isLegsColumnOrderAsc, data);
    return drawTable('front', data);
  });

}).call(this);
