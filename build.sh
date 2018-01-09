#!/usr/bin/env bash
cd frontend/react-redux-counter-app/
npm install
cd ../../
./sbt clean buildFrontends packageZipTarball