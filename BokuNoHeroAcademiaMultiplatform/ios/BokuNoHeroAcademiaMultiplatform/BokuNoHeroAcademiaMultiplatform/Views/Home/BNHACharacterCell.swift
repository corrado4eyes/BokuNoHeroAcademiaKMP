//
//  BNHACharacterCell.swift
//  BokuNoHeroAcademiaMultiplatform
//
//  Created by Corrado Quattrocchi on 18/06/2020.
//  Copyright © 2020 Corrado Quattrocchi. All rights reserved.
//

import Foundation
import UIKit
import shared
import Kingfisher

class BNHACharacterCell : UITableViewCell {
    
    // MARK: View Properties
    
    @IBOutlet weak var characterImage: UIImageView!
    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var characterClass: UILabel!
    @IBOutlet weak var category: UILabel!
    @IBOutlet weak var quirk: UILabel!
    
    // MARK: Business Logic Properties
    
    private var character: BNHACharacterResponse?
    
    // MARK: Public Methods
    
    func configure(character: BNHACharacterResponse) {
        self.character = character
        self.configureCell()
    }
    
    // MARK: Private Methods
    
    private func configureCell() {
        guard let character = self.character else { return }
        configureImage(url: character.image)
        name.text = character.name
        characterClass.text = character.characterClass
        category.text = character.category
        quirk.text = character.quirk
    }
    
    private func configureImage(url: String) {
        guard let url = URL(string: url) else { return }
        characterImage.kf.setImage(with: url)
    }
}
