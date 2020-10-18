import React, { useState } from "react"
import { Insurance, Response } from "../../types"
import { Form } from "../Form"
import * as API from "../../Api"
import "./App.css"
import { Modal } from "../Modal"

type State = { complete: boolean, result: Response | null }

/**
 * The entrypoint for the car insurance application.
 * It controls what content is rendered given the application state. (such as showing/hiding modal)
 */
export function App(): JSX.Element {
    const [state, setState] = useState<State>({ complete: false, result: null })

    async function onSubmit(insurance: Insurance) {
        const response: Response = await API.createInsurance(insurance)
        setState({ complete: true, result: response })
    }

    function closeModal() {
        setState({ complete: false, result: null })
    }

    return <div className={"flex flex-col p-4 md:w-3/5 m-auto max-w-2xl"}>
        <h1 className={"text-center text-4xl mb-6 font-bold"}>Kjøp bilforsikring</h1>
        <p className={"text-center md:text-left mb-8"}>
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiuesmod tempor incididunt ut labore et dolore magna aliqua.
            Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut.
        </p>
        <Form createInsurance={onSubmit} />
        {renderModal(state.complete, closeModal, state.result)}
    </div>
}

function renderModal(formComplete: boolean, onClose: Function, response: Response | null): JSX.Element | null {
    if (!formComplete || !response) return null

    let content: JSX.Element;
    if (response.success) {
        content = <>
            <p>Your insurance was created and accepted.</p>
            <p>We have sent you an email with the details.</p>
            <p className={"mt-4 font-bold"}>Here is your insurance number:</p>
            <span className={"m-auto"}>{response?.data.insuranceAgreementNumber}</span>
        </>
    } else {
        content = <>
            <p>We failed to create your insurance</p>
            <p className={"mt-4 font-bold cursor-pointer"} onClick={() => onClose()}>Please try again</p>
        </>
    }

    return <Modal closeModal={onClose} >
        <div className={"text-center"}>
            {content}
        </div>
    </Modal>
}