package com.sociteGeneral.Katabank;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sociteGeneral.model.BankAcount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class KataBankApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void noParamBankAcountsShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/bankAcounts")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("BankAcounts"));
	}

	@Test
	public void paramBankAcountsShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/bankAcounts").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("get Specific BankAcount!"));
	}

}
