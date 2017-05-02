drawTable = (id, data) ->
  clearRows(id)
  i = 0
  while i < data.length
    drawRow id, data[i]
    i++

clearRows = (id) ->
  $('#' + id + ' tbody').remove()

drawRow = (id, rowData) ->
  row = $('<tr />')
  $('#' + id).append row
  row.append $('<td>' + rowData[0] + '</td>')
  row.append $('<td>' + rowData[1] + '</td>')

numericAscOrder = (data) ->
  data.sort (element, nextElement) ->
    element[1] - nextElement[1]

alphabeticAscOrder = (data) ->
  data.sort (element, nextElement) ->
    firstLetterFirstElement = element[0][0]
    firstLetterNextElement = nextElement[0][0]
    if (firstLetterFirstElement < firstLetterNextElement)
      -1
    else if (firstLetterFirstElement == firstLetterNextElement)
      0
    else
      +1

reverseForDescOrder = (isColumnOrderAsc, data) ->
  if (isColumnOrderAsc == null || !isColumnOrderAsc)
    isColumnOrderAsc = true
  else if (isColumnOrderAsc)
    data.reverse()
    isColumnOrderAsc = false
  isColumnOrderAsc


# Global functions
window.drawTable = drawTable
window.clearRows = clearRows
window.drawRow = drawRow
window.numericAscOrder = numericAscOrder
window.alphabeticAscOrder = alphabeticAscOrder
window.reverseForDescOrder = reverseForDescOrder
