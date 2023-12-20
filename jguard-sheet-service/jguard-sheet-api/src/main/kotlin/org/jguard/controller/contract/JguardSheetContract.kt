package org.jguard.controller.contract

import org.jguard.port.model.Sheet
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/jguard/sheet/v1/")
interface JguardSheetContract {

    fun retrieveSheet(@RequestParam lang: String): ResponseEntity<Sheet>;
}