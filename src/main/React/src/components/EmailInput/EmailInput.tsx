import React, { useRef, useState, useEffect } from "react";
import "./EmailInput.css"

type Props = {
    name: string,
    value: string,
    placeholder: string,
    onChange(event)
}
type State = { value: string, valid: boolean }

const EMAIL_REGEX = new RegExp(/[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}/i)

/**
 * The email input. This input acts like a normal input, but it also validates its value and shows an error message
 * if the value is not a valid email. It only does this check when a new value is passed from props, and on blur.
 * @param Props
 */
export function EmailInput({ name, value, placeholder, onChange }: Props) {
    const [state, setState] = useState<State>(createState(value))
    useEffect(() => { setState(createState(value)) }, [value])

    const inputRef = useRef<HTMLInputElement>(null)

    function onBlur() {
        const value: string = inputRef.current?.value || ""
        setState(createState(value))
    }

    const errorClass = state.valid ? "" : "c-email_input--invalid"
    return <div className={"c-email_input__wrapper flex flex-col"}>
        <input
            {...{ name, placeholder }}
            className={`c-input c-input--medium ${errorClass}`}
            onBlur={onBlur} ref={inputRef} onChange={onChange} value={state.value}
        />
        <span>
            {errorMessage(state.valid)}
        </span>
    </div>
}

function createState(value: string): State {
    return { value, valid: isValidEmail(value) }
}

function isValidEmail(email: string): boolean {
    return email === "" || EMAIL_REGEX.test(email)
}

function errorMessage(valid: boolean): JSX.Element | null {
    if (valid) return null
    return <span className={"c-error"}>
        <span className="dot mr-2"></span>
        Skriv inn en gyldig epostadresse
    </span>
}