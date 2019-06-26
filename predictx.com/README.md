# Pi Challenge - Angular 2

Angular 2 front for Pi Challenge code test (wording should be in the same directory as this file, same name, PDF extension).

Production build is deployed in http://pi.basallo.es

## Notes to the reviewer

Everything, except for the highchart's option object JSON representation, is included in the model.

Those JSON can be found in /src/app/services/data; the first four are used to build the initial data included.

The default column number for the dashboard is 2 and the first chart is using the whole width, while the others the minimum.

The last one is offered as a default in the element creation dialog JSON input field.

The "Service" included in /src/app/services/ is simulating what, in a real with backend app, would be that traffic.

Initial data is provided from the mentioned files and on change, all linked components update state.

This should be, of course, a full fledged JSON enabled service in a real app, communicating with the backend that, for this exercise purposes, does not exists. 

## Getting Started

This steps will get you a copy of the project up and running locally for development purposes. 

See deployment for notes on how to deploy the project on a live system.

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.1.3.

### Installing

Run nvm to install appropriate node version:

`nvm install`

Optionally install yarn (I'll use it as default from now on):

`npm install -g yarn`

Run to install Angular CLI command line tool:

`yarn global add @angular/cli` 

Download required dependencies.

`yarn install` 

### Running the local development server

`yarn start` for a dev server. Navigate to `http://localhost:4200/`. 

The app will automatically reload if you change any of the source files.

### Running the tests

#### Test Coverage

Run `yarn coverage` to execute the unit tests via [Istanbul](https://istanbul.js.org/).

Check /coverage/ directory for generated HTML results.

#### Unit

Run `yarn test` to execute the unit tests via [Karma](https://karma-runner.github.io).

#### E2E

Run `yarn e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

### Running the linter

Run `yarn lint` to execute the linter via [tslint](https://github.com/palantir/tslint).

### Deployment

#### Local Build

Run `ng build` or `yarn build` to build the project. The build artifacts will be stored in the `dist/` directory. 

#### Production Build

Use the `-prod` flag for a production build.

## Author

* **Álvaro Basallo** - [basallo.es](http://basallo.es).
