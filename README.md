# CMPUT 301: Lab 8 Participation Exercise

<!--
Replication prompt 6: Complete the submission documentation
Source: OpenAI Codex conversation; retrospective instructions for recreating the lab.

Update README.md with full name Dean Elbery, CCID delbery, references to the lab
description and slides, disclosure of OpenAI Codex assistance, and N/A for verbal
collaboration. Include build instructions, verified test results, and links to the
failing and passing CI runs. Update only the copyright name in LICENSE.md. Commit
and push the documentation.
-->

## Student Details
- **Full Name:** Dean Elbery
- **CCID:** `delbery`

## References and Resources
- [Lab 8 description](lab-08-description.md).
- CMPUT 301 Lab 8 slides, *Continuous Integration and Test-driven Development* (Michelle Deng, 2026).
- OpenAI Codex (implementation and verification support).

## Verbal Collaboration
N/A

## Build and Test

Open the `lab8` folder in Android Studio, or run from that folder:

```shell
./gradlew build --configuration-cache
```

GitHub Actions runs the same build and unit tests on each push.

## Lab Behavior

- `restoreMana(amount)` adds mana and caps the result at 100.
- `train()` spends 5 mana to increase spell power by 1 when at least 5 mana is
  available. With less than 5 mana, both values remain unchanged.
- `WizardTest` covers mana restoration below and above the cap, training with
  exactly 5 mana, and refusing to train with 4 mana. The original spell tests
  are preserved.

## Test-driven Development

The tests and empty method skeletons were committed and pushed before each
implementation. Each red phase was verified locally and in GitHub Actions.

| Phase | Result | GitHub Actions run |
| --- | --- | --- |
| Starter build | Passed | [Baseline](https://github.com/EazyDean/lab-08/actions/runs/41111099051) |
| `restoreMana()` red phase | Failed: 2 restoration tests | [Failing restoration tests](https://github.com/EazyDean/lab-08/actions/runs/41111166916) |
| `restoreMana()` green phase | Passed | [Restoration implementation](https://github.com/EazyDean/lab-08/actions/runs/41112074317) |
| `train()` red phase | Failed: training with sufficient mana | [Training tests before implementation](https://github.com/EazyDean/lab-08/actions/runs/41112136256) |

The final implementation's build status is available in
[Android CI](https://github.com/EazyDean/lab-08/actions/workflows/ci.yml).

## Verification

- `./gradlew build --configuration-cache` passes locally.
- All 7 unit tests pass, including the 6 tests in `WizardTest`.
- Debug and release APKs build, and Android lint passes.

## Submission

Submit `https://github.com/EazyDean/lab-08` on Canvas.

## Replication Prompt References

Prompts 2-6 from the OpenAI Codex conversation are recorded as comments beside
the relevant code or documentation. These prompts were written after the lab
was completed as instructions to recreate it.

| Prompt | Location |
| --- | --- |
| 2: Restoration tests and skeleton | [WizardTest.kt](lab8/app/src/test/java/com/example/lab_8/WizardTest.kt), above the restoration tests |
| 3: Restoration implementation | [Wizard.kt](lab8/app/src/main/java/com/example/lab_8/Wizard.kt), above `restoreMana()` |
| 4: Training tests and skeleton | [WizardTest.kt](lab8/app/src/test/java/com/example/lab_8/WizardTest.kt), above the training tests |
| 5: Training implementation | [Wizard.kt](lab8/app/src/main/java/com/example/lab_8/Wizard.kt), above `train()` |
| 6: Submission documentation | HTML comment above Student Details in this README; also covers LICENSE.md |
