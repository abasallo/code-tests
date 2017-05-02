(function() {
  var alphabeticAscOrder, clearRows, drawRow, drawTable, numericAscOrder, reverseForDescOrder;

  drawTable = function(id, data) {
    var i, _results;
    clearRows(id);
    i = 0;
    _results = [];
    while (i < data.length) {
      drawRow(id, data[i]);
      _results.push(i++);
    }
    return _results;
  };

  clearRows = function(id) {
    return $('#' + id + ' tbody').remove();
  };

  drawRow = function(id, rowData) {
    var row;
    row = $('<tr />');
    $('#' + id).append(row);
    row.append($('<td>' + rowData[0] + '</td>'));
    return row.append($('<td>' + rowData[1] + '</td>'));
  };

  numericAscOrder = function(data) {
    return data.sort(function(element, nextElement) {
      return element[1] - nextElement[1];
    });
  };

  alphabeticAscOrder = function(data) {
    return data.sort(function(element, nextElement) {
      var firstLetterFirstElement, firstLetterNextElement;
      firstLetterFirstElement = element[0][0];
      firstLetterNextElement = nextElement[0][0];
      if (firstLetterFirstElement < firstLetterNextElement) {
        return -1;
      } else if (firstLetterFirstElement === firstLetterNextElement) {
        return 0;
      } else {
        return +1;
      }
    });
  };

  reverseForDescOrder = function(isColumnOrderAsc, data) {
    if (isColumnOrderAsc === null || !isColumnOrderAsc) {
      isColumnOrderAsc = true;
    } else if (isColumnOrderAsc) {
      data.reverse();
      isColumnOrderAsc = false;
    }
    return isColumnOrderAsc;
  };

  window.drawTable = drawTable;

  window.clearRows = clearRows;

  window.drawRow = drawRow;

  window.numericAscOrder = numericAscOrder;

  window.alphabeticAscOrder = alphabeticAscOrder;

  window.reverseForDescOrder = reverseForDescOrder;

}).call(this);
