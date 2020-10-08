import Axios from "axios"
import { Insurance, Response } from "../types"

const root = "/insurance/car"


export async function createInsurance(info: Insurance): Promise<Response> {
    try {
        const response = await Axios.post(root, info)

        if (response.status === 200) return { success: true, data: response.data }
        return { success: false, data: null }
    } catch (_e) {
        return { success: false, data: null }
    }
}