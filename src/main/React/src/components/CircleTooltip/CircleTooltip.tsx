import React, { useState } from "react"
import "./CircleTooltip.css"

/**
 * Simple component to show/hide a tooltip for the bonus.
 * The content is currently hardcoded, but could be changed to be passed as `children`
 */
export function CircleTooltip(): JSX.Element {
    const [isShown, setVisibility] = useState<boolean>(false)
    const shownClass = isShown ? "c-circle--shown" : ""

    return <div>
        <div
            className={`c-circle ${shownClass} inline-block border border-border-gray ml-2 cursor-pointer`}
            onClick={() => setVisibility(!isShown)}
        ></div>
        {showContent(isShown)}
    </div>
}

/**
 * Returns the tooltip if isShown is true
 * @param isShown Boolean to indicate if we should show content or not
 */
function showContent(isShown: boolean): JSX.Element | null {
    if (!isShown) return null
    return <div className={"absolute z-10 bg-white border border-border-gray p-2 rounded"}>
        Learn more here: <a href={"https://www.klp.no/forsikring/bilforsikring/hva-er-bonus"} target="_blank" className={"underline"}>www.klp.no</a>
    </div>
}