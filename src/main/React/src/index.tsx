import 'react-app-polyfill/ie11';

import React from "react"
import ReactDOM from 'react-dom';
import { App } from "./components/App"
import "./compiled.css"

ReactDOM.render(<App />, document.getElementById('root'))