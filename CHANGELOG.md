# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

## 2026.02.04

### Added - Brainstorming

-Added background information about myself and talked about my interests and some ideas for my component.

- Designed a DiscreteSignal component.
- Designed a DigitalRegister component.
- Designed a FiniteStateMachine component.

## 2026.02.25

### Added - Proof of Concept

- Designed and implemented a proof of concept for the - DigitalRegister component.
- Implemented core kernel methods including setBit, clearBit, getBit, and clear.
- Added index validation to ensure safe bit access.
- Included basic Javadoc documentation for all public methods.
- Created internal representation using a boolean array to model register state.

### Updated

- Refind clearBit method to correctly modify register state

## 2026.03.07

### Added - Interfaces

- Designed kernel interface DigitalRegisterKernel
- Designed enhanced interface DigitalRegister
- Added method contracts using OSU design-by-contract style
- Created hierarchy diagram showing relationship between Standard Kernel, and Enhanced interfaces

### Updated 2

- Refined component design so that higher-level operations are layered on kernel bit operations.

## 2026.04.01

### Added - Abstract Class

- Implemented DigitalRegisterSecondary abstract class.
- Implemented secondary methods using only kernel methods.
- Added toString(), equals(), and hashCode() methods.
- Added Javadoc for class and all methods.

## 2026.04.11

### Added - Kernel Implementation

- Implemented kernel class DigitalRegister1L using a boolean array representation
- Defined representation invariant (convention) and abstraction function (correspondence)
- Implemented all kernel methods (setBit, clearBit, getBit, width)
- Implemented required standard methods (clear, newInstance, transferFrom)
- Added constructors for initializing register with specified width

### Updated 3

- Finalized full DigitalRegister component by integrating kernel implementation with existing interfaces and secondary methods.

## 2026.04.18

### Added - Finishing Touches

- Designed JUnit test files for DigitalRegister component covering all kernel and secondary methods
- Added boundary test cases for shiftLeft and shiftRight methods
- Added state verification test cases to ensure methods do not unintentionally modify register state
- Designed two qualitatively different use cases for the DigitalRegister component
- Implemented DigitalRegisterCounterDemo demonstrating binary counter behavior
- Implemented DigitalRegisterShiftDemo demonstrating bit shifting and manual bit manipulation
- Completed the reflections on software development process and personal growth

### Updated 4

- Fixed test assertions to correctly use assertTrue and assertFalse for boolean getBit return type
- Replaced assertEquals(false, ...) with assertNotEquals for cleaner test style
- Added expected value comments to demo files to make it easier for readers to follow along
