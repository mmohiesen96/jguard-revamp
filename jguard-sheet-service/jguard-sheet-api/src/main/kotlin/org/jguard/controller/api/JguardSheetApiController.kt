package org.jguard.controller.api

import org.jguard.controller.contract.JguardSheetContract
import org.jguard.port.function.SheetFunction
import org.jguard.port.model.Sheet
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JguardSheetApiController(private val sheetFunction: SheetFunction) : JguardSheetContract {

    @GetMapping
    override fun retrieveSheet(lang: String): ResponseEntity<Sheet> = ResponseEntity.ok(sheetFunction.parseSheet(lang))

}