import Dashboards from '../../model/dashboards'
import Dashboard from '../../model/dashboard'
import Element from '../../model/element'

import json1 from './json1'
import json2 from './json2'
import json3 from './json3'
import json4 from './json4'

const element1 = new Element(1, 'Element I', json1, 2, 1)
const element2 = new Element(2, 'Element II', json2, 1, 1)
const element3 = new Element(3, 'Element III', json3, 1, 1)
const element4 = new Element(4, 'Element IV', json4, 1, 1)

export default new Dashboards([
  new Dashboard(1, 'Dashboard I', [ element1 ]),
  new Dashboard(2, 'Dashboard II', [ element1, element2 ]),
  new Dashboard(3, 'Dashboard III', [ element1, element2, element3 ]),
  new Dashboard(4, 'Dashboard IV', [ element1, element2, element3, element4 ]),
])
