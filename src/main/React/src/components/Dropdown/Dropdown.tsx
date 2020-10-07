import React, { useEffect, useState } from "react"
import "./Dropdown.css"

type Props = {
    placeholder: string,
    choices: Choice[],
    value: string,
    name: string,
    onChange(name: string, value: string): void
}

type Choice = { value: string, label: string }
type State = { open: boolean, choice: Choice | null }

/**
 * The custom dropdown element. It does not currently have a hidden input, so submitting it inside a normal form wont work.
 * @param Props
 */
export function Dropdown({ choices, value, name, placeholder, onChange }: Props): JSX.Element {
    const [state, setState] = useState<State>({ choice: findChoice(choices, value), open: false })
    useEffect(() => { setState({ choice: findChoice(choices, value), open: state.open }) }, [value])

    function onChoiceClick(value: string) {
        setState({ choice: findChoice(choices, value), open: false })
        onChange(name, value)
    }

    function toggleSelect() { setState({ ...state, open: !state.open }) }

    return <div className={"u-margin-bottom"}>
        <div onClick={toggleSelect} className={"c-input c-input--medium flex items-center mb-1 cursor-pointer relative u-no_select"}>
            {state.choice?.label || placeholder}
            {arrowSVG(state.open)}
        </div>

        <ul hidden={!state.open} className={"c-dropdown_choices"}>{renderChoices(choices, onChoiceClick, state.choice)}</ul>
    </div>
}

/**
 * This will create a list of li elements that will be used as the choices in the dropdown.
 * @param choices List of choices
 * @param onClick The onclick function
 * @param selectedChoice The selected choice
 */
function renderChoices(choices: Choice[], onClick: Function, selectedChoice: Choice | null): JSX.Element[] {
    return choices.map(choice => {
        let className = "c-dropdown_choice u-no_select"
        if (selectedChoice?.value === choice.value) className += " c-dropdown_choice--selected"

        return (
            <li
                className={className}
                onClick={() => onClick(choice.value)}
                key={choice.value}
            >
                {choice.label}
            </li>
        )
    })
}

/**
 * Given a list of choices, return the choice with the provided value
 * @param choices The list of choices
 * @param value The provided value which will be matched with choice.value
 */
function findChoice(choices: Choice[], value: string): Choice | null {
    return choices.filter(choice => choice.value === value)[0] || null
}

function arrowSVG(flip: boolean): JSX.Element {
    const transform = flip ? "scale(1, -1)" : ""

    return <svg viewBox="0 0 284.929 284.929" className={"c-dropdown__svg"} transform={transform}>
        <g>
            <path d="M282.082,76.511l-14.274-14.273c-1.902-1.906-4.093-2.856-6.57-2.856c-2.471,0-4.661,0.95-6.563,2.856L142.466,174.441
			L30.262,62.241c-1.903-1.906-4.093-2.856-6.567-2.856c-2.475,0-4.665,0.95-6.567,2.856L2.856,76.515C0.95,78.417,0,80.607,0,83.082
			c0,2.473,0.953,4.663,2.856,6.565l133.043,133.046c1.902,1.903,4.093,2.854,6.567,2.854s4.661-0.951,6.562-2.854L282.082,89.647
			c1.902-1.903,2.847-4.093,2.847-6.565C284.929,80.607,283.984,78.417,282.082,76.511z"/>
        </g>
    </svg>


}