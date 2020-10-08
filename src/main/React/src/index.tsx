import 'react-app-polyfill/ie11';

import React from "react"
import ReactDOM from 'react-dom';
import { App } from "./components/App"
import "./compiled.css"
import "./fonts/museo-sans.otf"

ReactDOM.render(<App />, document.getElementById('root'))