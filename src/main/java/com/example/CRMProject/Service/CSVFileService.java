package com.example.CRMProject.Service;

import com.example.CRMProject.Model.Admission;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.util.List;

public interface CSVFileService {

    ByteArrayInputStream Load();
}
