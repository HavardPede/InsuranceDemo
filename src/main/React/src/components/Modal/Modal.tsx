import React from "react"
import "./Modal.css"

/**
 * Simple modal component which renders the children within the modal.
 * Currently, clicking the background does not close the modal. This would be worth changing.
 * @param param0 
 */
export function Modal({ children, closeModal }): JSX.Element {
    return <div id="myModal" className="modal">
        <div className="modal-content">
            <span className="close" onClick={closeModal}>&times;</span>
            {children}
        </div>
    </div>
}