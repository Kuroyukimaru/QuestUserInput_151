package com.example.userinput

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormPendaftaran(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var statusPerkawinan by remember { mutableStateOf("") }

    val genderList = listOf("Laki-laki", "Perempuan")
    val statusList = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF182EA2), Color.White)
                )
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Formulir Pendaftaran",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color(0xFF4450BB), Color(0xFF7491FF))
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(vertical = 16.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.8f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {

                OutlinedTextField(
                    value = textNama,
                    onValueChange = { textNama = it },
                    label = { Text("Isian nama lengkap") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Text("Jenis Kelamin", fontWeight = FontWeight.SemiBold)
                genderList.forEach { gender ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = textJK == gender,
                                onClick = { textJK = gender }
                            )
                            .padding(start = 8.dp, top = 4.dp)
                    ) {
                        RadioButton(
                            selected = textJK == gender,
                            onClick = { textJK = gender }
                        )
                        Text(gender)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Status Perkawinan
                Text("Status Perkawinan", fontWeight = FontWeight.SemiBold)
                statusList.forEach { status ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .selectable(
                                selected = textStatus == status,
                                onClick = { textStatus = status }
                            )
                            .padding(start = 8.dp, top = 4.dp)
                    ) {
                        RadioButton(
                            selected = textStatus == status,
                            onClick = { textStatus = status }
                        )
                        Text(status)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Alamat
                OutlinedTextField(
                    value = textAlamat,
                    onValueChange = { textAlamat = it },
                    label = { Text("Alamat") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                nama = textNama
                jenisKelamin = textJK
                statusPerkawinan = textStatus
                alamat = textAlamat
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001473)),
            shape = RoundedCornerShape(12.dp),
            enabled = textNama.isNotEmpty() && textJK.isNotEmpty() && textStatus.isNotEmpty() && textAlamat.isNotEmpty()
        ) {
            Text("Submit", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (nama.isNotEmpty()) {
            ElevatedCard(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF3D59C0)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Nama: $nama", color = Color.White)
                    Text("Jenis Kelamin: $jenisKelamin", color = Color.White)
                    Text("Status Perkawinan: $statusPerkawinan", color = Color.White)
                    Text("Alamat: $alamat", color = Color.White)
                }
            }
        }
    }
}