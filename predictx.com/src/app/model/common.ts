export default class Common {

  nextId(array: any[]): number {
    if (array.length > 0) {
      return array[array.length - 1].id + 1
    } else {
      return 1
    }
  }
}
