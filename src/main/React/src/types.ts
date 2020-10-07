export type Insurance = {
    registrationNumber: string,
    email: string,
    birthNumber: number | null,
    forename: string,
    surname: string
    bonus: string,
}

export type ResponseData = { insuranceAgreementNumber: string, status: string }

export type Response = { success: true, data: ResponseData } | { success: false, data: null }