# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.02.04

### Added

-Added background information about myself and talked about my interests and some ideas for my component.

- Designed a DiscreteSignal component.
- Designed a DigitalRegister component.
- Designed a FiniteStateMachine component.

## 2026.02.25

### Added 2

- Designed and implemented a proof of concept for the DigitalRegister component.
- Implemented core kernel methods including setBit, clearBit, getBit, and clear.
- Added index validation to ensure safe bit access.
- Included basic Javadoc documentation for all public methods.
- Created internal representation using a boolean array to model register state.

### Updated

- Refind clearBit method to correctly modify register state
