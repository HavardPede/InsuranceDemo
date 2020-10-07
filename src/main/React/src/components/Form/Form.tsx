import React, { useState } from "react"
import { EmailInput } from "../EmailInput";
import { Dropdown } from "../Dropdown";
import { CircleTooltip } from "../CircleTooltip";
import { Insurance } from "../../types"
import "./Form.css"

const INITIAL_STATE: Insurance = {
    registrationNumber: "",
    bonus: "",
    birthNumber: null,
    forename: "",
    surname: "",
    email: ""
}
function initialState(): Insurance {
    return {
        registrationNumber: "",
        bonus: "",
        birthNumber: null,
        forename: "",
        surname: "",
        email: ""
    }
}
type Props = { createInsurance(Insurance): void }

/**
 * This turned out to be the chunk of the application. This mainly controls the form and the state of the form.
 * It also handles submitting and clearing the form.
 * 
 * Currently, it is not doing any verification on any of the form inputs expect for email. It could be worth 
 * changing this to ensure we do not submit empty values etc.
 * @param Props
 */
export function Form({ createInsurance }: Props): JSX.Element {
    const [state, setState] = useState<Insurance>(initialState())

    function onSubmit() {
        createInsurance(state)
        clearState()
    }

    function clearState() { setState({ ...initialState() }) }

    /**
     * Given a change event, this will fetch the input information and call storeValueInState.
     * @param event 
     */
    function onChange(event) {
        const input: HTMLInputElement | null = event.target
        if (!input) return

        const name = input.name
        const value = name === "birthNumber" ? parseInt(input.value) : input.value

        storeValueInState(name, value)
    }

    /**
     * Given a name and a value, store the value in the state.
     * @param name 
     * @param value 
     */
    function storeValueInState(name, value) {
        let changes: Partial<Insurance> = {}
        changes[name] = value;

        setState({ ...state, ...changes })
    }

    return <div className={"flex flex-col"}>
        <h2>Bilens registeringsnummer</h2>
        <input
            name={"registrationNumber"}
            placeholder={"AB 12345"}
            className={"c-input c-input--small u-margin-bottom"}
            onChange={onChange}
            value={state.registrationNumber}
        />

        <h2 className={"flex items-center"}>Din bonus<CircleTooltip /></h2>
        <Dropdown
            choices={[{ label: "The Best", value: "best" }, { label: "Decent", value: "ok" }]}
            value={state.bonus}
            name={"bonus"}
            placeholder={"velg din bonus..."}
            onChange={storeValueInState}
        />

        <h2>Fødselsnummer</h2>
        <input
            name={"birthNumber"}
            placeholder={""}
            className={"c-input c-input--small u-margin-bottom u-margin-bottom"}
            onChange={onChange}
            type={"number"}
            value={state.birthNumber + ""}
        />

        <div className={"flex flex-wrap"}>
            <span className={"flex-col"}>
                <h2>Fornavn</h2>
                <input
                    name={"forename"}
                    placeholder={""}
                    className={"c-input c-input--medium mr-4 u-margin-bottom "}
                    onChange={onChange}
                    value={state.forename}
                />
            </span>

            <span className={"flex-col"}>
                <h2>Etternavn</h2>
                <input
                    name={"surname"}
                    placeholder={""}
                    className={"c-input c-input--medium u-margin-bottom "}
                    onChange={onChange}
                    value={state.surname}
                />
            </span>
        </div>

        <h2>E-post</h2>
        <EmailInput name={"email"} value={state.email} placeholder={""} onChange={onChange} />

        <div className={"flex"}>
            <button className={"c-button c-button--large bg-button-blue text-white font-bold rounded mr-4"} onClick={onSubmit}>
                Beregn pris
            </button>
            <button className={"c-button bg-white text-button-blue border border-border-gray u-height font-bold rounded"} onClick={clearState}>
                Avbryt
            </button>
        </div>
    </div>
}